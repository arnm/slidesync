(ns slidesync.handlers)

(defn clients-handler
  [req]
  (str (get-in req [:request :headers])))

(defn client-handler
  [req id]
  (str "This is client: " id))
