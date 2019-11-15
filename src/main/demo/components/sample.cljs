(ns main.demo.components.sample
  (:require [hx.react :as hx]))

(hx/defnc SampleComponent [{:keys [text children]}]
  [:<>
   [:h1 "Sample Component"]
   [:div "This is the passed text: " [:b text]]
   [:div "And here are the children:"]
   children])
