set -e

echo "Clean"
rm -Rf out || true

echo "Build"
javac src/ru/novsu/povt/roginvs/graphics/*.java src/ru/novsu/povt/roginvs/*.java -d out

echo "Run"
echo ""
(cd out && java ru.novsu.povt.roginvs.Roginvs)