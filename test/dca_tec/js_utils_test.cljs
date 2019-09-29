(ns dca-tec.js-utils-test
  (:require [clojure.test :refer [deftest is testing]]
            [cljs.core.async :as async]
            [dca-tec.js-utils :as jsu]))


(defn setupTestData! [doc]
  "Adds to doc's body element a div of the form:
  '<div id=\"testId1\" style=\"color: blue;\">Some content text</div>'
  and also returns the created div element."
  (let [newDiv (.createElement doc "div")]
    (.setAttribute newDiv "id" "testId1")
    (.setAttribute newDiv "style" "color: blue;")
    (set! (.-innerHTML newDiv) "Some content text")
    (.appendChild (.-body doc) newDiv)
    newDiv))

(deftest test-js-utils
  (let [doc js/document]
    (setupTestData! doc)
    (testing
      "Get an element by its id"
      (let [result (jsu/getElementById! "testId1")]
        (is (not (nil? result)))
        (is (= "Some content text") (.-content result))))
    (testing
      "Getting an element that does not exist returns nil"
      (is (nil? (jsu/getElementById! "non existing id"))))
    (testing
      "Register a (message) window event listener and wait for the handler to react when a message is posted to window."
      (let [message-channel (async/chan)
            handler (fn [] (async/put! message-channel "MessageReceived"))]
        (jsu/registerWindowEvent! "message" handler)
        (.postMessage js/window "hi")
        (async/take! message-channel #(is (= "MessageReceived" %)))))
    (testing
      "Registering a window event of a type that doesn't exist has no effect"
      (jsu/registerWindowEvent! "bogusEventName" #()))))

