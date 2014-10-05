(ns slidesync.resources
  (:require [liberator.core :refer [defresource]])
  (:use [slidesync.handlers]))

(defresource clients-resource
  :available-media-types ["text/plain"]
  :allowed-methods [:get :post]
  :handle-ok clients-handler)

(defresource client-resource
  [id]
  :available-media-types ["text/plain"]
  :allowed-methods [:get :put]
  :handle-ok (fn [req] (client-handler req id)))
