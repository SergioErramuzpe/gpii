cd app-android
echo -e "Analisis de la aplicacion Android"
./gradlew testReleaseUnitTest
echo -e "Analisis de la aplicacion Android finalizado"
cd ../