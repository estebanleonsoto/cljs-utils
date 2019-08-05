(ns dca-tec.chrome-test
  (:require  [clojure.test :refer [deftest]]
             [clj-chrome-devtools.cljs.test :refer [build-and-test]]))

(deftest run-chrome-test
 (build-and-test "test"
                 '[dca-tec.js-utils-test]))