== TODO
* Create WEB-INF dir if if doesn't exist when starting the server
* It seems like the core-handler used by GaeshiDevServlet is not being reloaded by fresh
* '_ah/admin/backends' and _ah/admin/inboundmail routes aren't working
* generate sample model, controller, view with specs
* spec_helpers/controller must record all views rendered in addition to the last.
* the devserver should run a repl server
* need to resolve conflict with hiccup files. The .clj extension should be removed, and prepare-views task updated to exclude *.clj files.
* Add session clearing cron job to generated project
* Add a away to bypass timestamp updates in the datastore
* Need to address problem where data is not loaded properly when the models haven't been loaded yet.
* Prepare task should run clean to empty classes dir. server task should not clean.
