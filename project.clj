(defproject slidesync "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-ring "0.8.12"]
            [lein-environ "1.0.0"]]
  :ring {:handler slidesync.core/handler}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [liberator "0.12.2"]
                 [ring "1.3.1"]
                 [compojure "1.2.0"]
                 [postgresql/postgresql  "9.3-1102.jdbc41"]
                 [korma "0.4.0"]
                 [environ "1.0.0"]]
  :main ^:skip-aot slidesync.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
