(ns slidesync.core
  (:require [ring.middleware.params :refer [wrap-params]]
            [ring.adapter.jetty :refer [run-jetty]]
            [compojure.core :refer [defroutes GET]]
            [environ.core :refer [env]])
  (:use [slidesync.resources]
        [slidesync.models])
  (:gen-class))

(defroutes app
  (GET "/clients" [] clients-resource)
  (GET "/clients/:id" [id] (client-resource id)))

(def handler
  (-> app
      wrap-params))

(defn -main
  [& [port]]
  (run-jetty handler {:port (or port (env :port))}))
