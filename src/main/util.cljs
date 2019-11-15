(ns main.util
  (:require-macros [main.util])
  (:require
   ["react" :as react]
   [hx.react :as hx]
   [shadow.lazy :as lazy]))

;; the lazy-component macro will emit a simple

;; (demo.util/lazy-component* (shadow.lazy/loadable some.qualified/symbol))

;; you don't actually need this wrapper macro, I just wanted the code to be extra
;; short for demo purposes.

(defn lazy-component* [loadable]
  (react/lazy
    (fn []
      (-> (lazy/load loadable)
          (.then (fn [root-el]
                   ;; React.lazy expects to load a ES6 module with a React Component as default export

                   (if-not js/goog.DEBUG
                     ;; this would be more correct in production settings
                     #js {:default root-el}

                     ;; we need wrap the loaded component one extra level so live-reload actually works
                     ;; since React will keep a reference to the initially loaded fn and won't update it
                     #js {:default (fn [props]
                                     (js/console.log "lazy load")
                                     (@loadable props))})
                   ))))))
