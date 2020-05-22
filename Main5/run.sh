set -e

echo "Clean"
rm -Rf out || true

echo "Compile"
javac graphics/*.java *.java -d out


echo "Run"
echo ""
(cd out && java Main5)