;;; This namespace is used for testing purpose. It use the
;;; clojurescript.test lib.
(ns dca-tec.js-utils-test
  (:require-macros [cemerick.cljs.test :as m :refer (deftest testing are)])
  (:require [cemerick.cljs.test :as t]
            [dca-tec.js-utils :refer (foo)]))

(deftest foo-test
  (testing "I don't do a lot\n"
    (testing "Edge cases\n"
      (testing "(foo str)"
        (are [expected actual] (= expected actual)
             "ClojureScript!" (foo "")
             "Hello, ClojureScript!" (foo nil))))))
