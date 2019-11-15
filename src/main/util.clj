(ns main.util)

(defmacro lazy-component [the-sym]
  `(main.util/lazy-component* (shadow.lazy/loadable ~the-sym)))
