(defproject dca-tec/js-utils "0.0.1-SNAPSHOT"
  :description "A set of basic general purpose functions to work in a JavaScript environment."
  :license {:name "MIT Licence"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.520"]
                 [org.clojure/core.async "0.4.500"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-doo "0.1.11"]
            [lein-codox "0.10.7"]]

  :profiles
    {:dev
      {:dependencies
         [[org.clojure/core.async "0.4.500"]
          [clj-chrome-devtools "20190601"]]}}

  :cljsbuild
    {:builds
     [{:id "prod"
       :source-paths ["src"]
       :compiler
         {:optimizations :advanced
          :output-to     "app.js"
          :closure-output-charset "US-ASCII"}}
      {:id "test"
       :source-paths ["src" "test"]
       :compiler
         {:output-to "target/test.js"
          :optimizations :whitespace
          :pretty-print  true
          :closure-output-charset "US-ASCII"}}]}

  :codox
    {:language :clojurescript
     :output-path "docs/codox"
     :source-uri "https://github.com/tatut/tuck/blob/master/{filepath}#L{line}"}

  :scm {:name "git"
        :url "https://github.com/estebanleonsoto/cljs-utils"})

