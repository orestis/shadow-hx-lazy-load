(ns main.demo.app
  (:require
   ["react" :as react]
   ["react-dom" :as react-dom]
   [hx.react :as hx]
   [main.util :refer (lazy-component)]
   #_[main.demo.components.sample :refer [SampleComponent]]))

(defonce root-el (js/document.getElementById "root"))

(def SampleComponent (lazy-component main.demo.components.sample/SampleComponent))

(hx/defnc Loading []
  [:div "Loading..."])

(hx/defnc Root []
  [:div "Hello root"
   [react/Suspense {:fallback (hx/f [Loading])}
    [SampleComponent {:text "Some TEXT"}
     [:span "child"]
     [:span " is "]
     [:span "born"]]]])

(defn ^:dev/after-load start []
  (react-dom/render (hx/f [Root]) root-el))

(defn init []
  (start))
