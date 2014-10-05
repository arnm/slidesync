(ns slidesync.models
  (:require [clojure.java.jdbc :as sql]
            [korma.db :refer [defdb postgres]]
            [environ.core :refer [env]])
  (:use [korma.core]))

(def db-spec {:classname "org.postgresql.Driver"
              :subprotocol "postgresql"
              :subname (env :db-subname)})

(defdb db db-spec)

(defn create-client-table []
  (sql/db-do-commands db-spec
                      (sql/create-table-ddl
                        :client
                        [:id :serial "PRIMARY KEY"]
                        [:first_name :text "NOT NULL"]
                        [:last_name :text "NOT NULL"]
                        [:email :text "UNIQUE" "NOT NULL"])))

(defn create-presentation-table []
  (sql/db-do-commands db-spec
                      (sql/create-table-ddl
                        :presentation
                        [:id :serial "PRIMARY KEY"]
                        [:client_id :serial "REFERENCES client(id)"]
                        [:name :text "NOT NULL"]
                        [:media_path :text "NOT NULL"]
                        [:slides_path :text "NOT NULL"])))

(defn create-tables []
  (create-client-table)
  (create-presentation-table))

(comment
  (create-tables))
