cd app-android
echo -e "Tests de la aplicacion Android"
./gradlew testReleaseUnitTest
echo -e "Tests de la aplicacion Android finalizado"
cd ../
cd sonarqube/bin/linux-x86-64
echo -e "Iniciando SonarQube"
./sonar.sh start
cd ../../../
echo -e " "
echo -e " "

cd app
echo -e "Tests de la Aplicacion-Web con SonarQube"
sonar-scanner \
  -Dsonar.projectKey=org.sonarqube:php-ut-sq-scanner \
  -Dsonar.tests=tests \
  -Dsonar.host.url=http://localhost:9000 
echo -e "Tests de la Aplicacion-Web con SonarQube finalizado"
xdg-open http://localhost:9000/dashboard/index/org.sonarqube:php-ut-sq-scanner
echo -e " "