
./standalone.sh -Dorg.kie.server.xstream.enabled.packages=com.myspace.mortgage_app.** -DserverUrl=http://localhost:8080/kie-server/services/rest/server -Duser=rhpamAdmin -Dpassword=jboss123$ -DcontainerId=mortgage-process_2.0.0

./standalone.sh -Dorg.kie.server.xstream.enabled.packages=com.myspace.mortgage_app.** -DserverUrl=http://myapp-kieserver-pamdemo.192.168.64.6.nip.io:80/services/rest/server -Duser=executionUser -Dpassword=RedHat -DcontainerId=mortgage-process

./standalone.sh -Dorg.kie.server.xstream.enabled.packages=com.myspace.mortgage_app.** -DserverUrl=http://myapp-kieserver-pamdemo.192.168.99.100.nip.io/services/rest/server -Duser=executionUser -Dpassword=RedHat -DcontainerId=mortgage-process_2.0.1 -DorigHost=http://myapp-kieserver-pamdemo.192.168.99.100.nip.io -Dorigport=80