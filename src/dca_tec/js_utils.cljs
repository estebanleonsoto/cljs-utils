(ns dca-tec.js-utils)

(defn getElementById! [id]
  (.getElementById js/document id))

(defn eventTarget [event]
  (.-target event))

(defn getStylesFromCSS [element]
  (js/window.getComputedStyle element))

(defn registerWindowEvent! [eventName handler]
  (-> js/window
      (.addEventListener eventName handler)))


