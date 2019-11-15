(ns main.demo.app
  (:require
   ["react" :as react]
   ["react-dom" :as react-dom]
   [hx.react :as hx]))

(defonce root-el (js/document.getElementById "root"))


(hx/defnc Root []
  [:div "Hello root"])

(defn ^:dev/after-load start []
  (react-dom/render (hx/f [Root]) root-el))

(defn init []
  (start))
