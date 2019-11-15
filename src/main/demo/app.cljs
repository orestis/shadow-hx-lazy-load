(ns main.demo.app
  (:require
   ["react" :as react]
   ["react-dom" :as react-dom]
   [hx.react :as hx]
   [main.demo.components.sample :as sample]))

(defonce root-el (js/document.getElementById "root"))


(hx/defnc Root []
  [:div "Hello root"
   [sample/SampleComponent {:text "Some TEXT"}
    [:span "child"]
    [:span " is "]
    [:span "born"]]])

(defn ^:dev/after-load start []
  (react-dom/render (hx/f [Root]) root-el))

(defn init []
  (start))
