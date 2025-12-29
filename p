[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO] 
[INFO] aia                                                                [pom]
[INFO] aia-core                                                           [jar]
[INFO] aia-api                                                            [jar]
[INFO] aia-spa                                                            [jar]
[INFO] 
[INFO] ------------------------< com.farfarcoder:aia >-------------------------
[INFO] Building aia 0.0.1-SNAPSHOT                                        [1/4]
[INFO]   from pom.xml
[INFO] --------------------------------[ pom ]---------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for aia 0.0.1-SNAPSHOT:
[INFO] 
[INFO] aia ................................................ FAILURE [  0.000 s]
[INFO] aia-core ........................................... SKIPPED
[INFO] aia-api ............................................ SKIPPED
[INFO] aia-spa ............................................ SKIPPED
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.339 s
[INFO] Finished at: 2025-12-29T18:24:54+09:00
[INFO] ------------------------------------------------------------------------
[ERROR] Unknown lifecycle phase "spa". You must specify a valid lifecycle phase or a goal in the format <plugin-prefix>:<goal> or <plugin-group-id>:<plugin-artifact-id>[:<plugin-version>]:<goal>. Available lifecycle phases are: pre-clean, clean, post-clean, validate, initialize, generate-sources, process-sources, generate-resources, process-resources, compile, process-classes, generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, test-compile, process-test-classes, test, prepare-package, package, pre-integration-test, integration-test, post-integration-test, verify, install, deploy, pre-site, site, post-site, site-deploy. -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/LifecyclePhaseNotFoundException
