(ns gaeshi.kuzushi.commands.server
  (:use
    [leiningen.core :only (read-project)]
    [leiningen.clean :only (clean)]
    [leiningen.classpath :only (get-classpath-string)]
    [gaeshi.cmd :only (java)]
    [gaeshi.kuzushi.common :only (symbolize load-lein-project)])
  (:import
    [mmargs Arguments]))

(def arg-spec (Arguments.))
(doto arg-spec
  (.addValueOption "p" "port" "PORT" "Change the port (default: 8080)")
  (.addValueOption "a" "address" "ADDRESS" "Change the address (default: 127.0.0.1)")
  (.addValueOption "e" "environment" "ENVIRONMENT" "Change the environment (default: development)")
  (.addValueOption "d" "directory" "DIRECTORY" "Change the directory (default: .)")
  (.addValueOption "j" "jvm-opts" "JVM OPTIONS" "Add JVM options"))

(def default-options {
  :port 8080
  :address "127.0.0.1"
  :environment "development"
  :directory "."})

(defn parse-args [& args]
  (let [options (symbolize (.parse arg-spec (into-array String args)))
        options (if (contains? options :port) (assoc options :port (Integer/parseInt (:port options))) options)]
    (merge default-options options)))

(defn execute
  "Starts the app in on a local web server"
  [options]
  (let [project (load-lein-project)
        classpath (get-classpath-string project)
        jvm-args ["-cp" classpath]
        args ["-p" (:port options) "-a" (:address options) "-e" (:environment options) "-d" (:directory options)]]
    (clean project)
    (java jvm-args "gaeshi.tsukuri.GaeshiDevServer" (map str args))))

