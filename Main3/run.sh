set -e

echo "Clean"
rm -Rf out || true

echo "Build"
javac Graph/*.java *.java -d out

echo "Run"
echo ""
(cd out && java Main3.Main3)