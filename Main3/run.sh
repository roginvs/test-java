set -e

echo "Clean"
rm -Rf out || true

echo "Compile"
javac src/ru/novsu/povt/roginvs/graphics/*.java src/ru/novsu/povt/roginvs/*.java -d out

echo "Build package"
(
    cd out &&
    jar -cfve my.jar \
      ru/novsu/povt/roginvs/Roginvs \
      ru/novsu/povt/roginvs/*.class \
      ru/novsu/povt/roginvs/graphics/*.class 
)

echo "Run"
echo ""
(cd out && java -jar my.jar)