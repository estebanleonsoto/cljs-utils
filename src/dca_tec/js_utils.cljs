(ns dca-tec.js-utils
  "## js-utils
  A set of basic utility functions and wrappers for basic java-script and
  dom-related work.
  The intention here is either to wrap js-platform calls with more simple
  functions. Simple in the sense of at least more simple and meaningfully
  named functions, but also in the sense of less parameters necessary or
  containing already references to the environment, like window, document, etc")

(defn getElementById!
  "Looks for the the element in the js document with the given id"
  [id]
  (.getElementById js/document id))

(defn eventTarget
  "Gets the target element of the event"
  [event]
  (.-target event))

(defn getStylesFromCSS
  "Gets the CSS styles completely computed out of all css associated to the element"
  [element]
  (js/window.getComputedStyle element))

(defn registerWindowEvent!
  "Registers the given event handler, so that it attends js-events with the given name"
  [eventName handler]
  (-> js/window
      (.addEventListener eventName handler)))


