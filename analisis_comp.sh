cd app-android
echo -e "Analisis de la aplicacion Android"
./gradlew lint
echo -e "Analisis de la aplicacion Android finalizado"
echo -e " "
echo -e " "
echo -e "Build de la aplicacion Android"
./gradlew build
echo -e "Build de la aplicacion Android finalizado"
echo -e " "
echo -e " "
echo -e "Creacion de la aplicacion Android (APK)"
./gradlew assemble
echo -e "Creacion de la aplicacion Android (APK) finalizado"
echo -e " "
echo -e " "
echo -e "Analisis de la aplicacion Android (APK)"
./gradlew lintAnalyzeRelease
echo -e "Analisis de la aplicacion Android (APK) finalizado"
echo -e " "
echo -e " "
cp app/build/outputs/apk/release/app-release-unsigned.apk ../app-android.apk
cd ../

cd sonarqube/bin/linux-x86-64
echo -e "Iniciando SonarQube"
./sonar.sh start
cd ../../

cd app
echo -e "Analisis de la Aplicacion-Web con SonarQube"
sonar-scanner   -Dsonar.projectKey=php   -Dsonar.sources=.   -Dsonar.host.url=http://localhost:9000   -Dsonar.login=783ccd838447d3102d7e96d1c1800e34400def70

open http://localhost:9000/dashboard/index/php
echo -e "Analisis de la Aplicacion-Web con SonarQube finalizado"
echo -e " "
echo -e " "
echo -e "Creacion de la Aplicacion-Web (PHAR)"
cd ../
php --define phar.readonly=0 compile.php
echo -e "Creacion de la Aplicacion-Web (PHAR) finalizado"