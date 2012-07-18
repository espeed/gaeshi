(ns gaeshi.kuzushi.spec-helper
  (:use [speclj.core]
        [joodo.kuzushi.common :only (exit *lib-name* *summary*)])
  (:import [java.io ByteArrayOutputStream OutputStreamWriter]))

(defn to-s [output]
  (String. (.toByteArray output)))

(defn with-command-help []
  [(with output (ByteArrayOutputStream.))
   (with writer (OutputStreamWriter. @output))
   (around [spec] (binding [*out* @writer] (spec)))
   (around [spec] (with-redefs [exit identity] (spec)))
   (around [spec] (binding [*lib-name* "gaeshi"
                            *summary* "gaeshi X.X.TEST"]
                    (spec)))])


