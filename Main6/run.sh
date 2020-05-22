set -e

echo "Clean"
rm -Rf out || true

echo "Compile"
javac *.java -d out


echo "Run"
echo ""
(cd out && java Main6)