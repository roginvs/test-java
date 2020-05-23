set -e

echo "Clean"
rm -Rf out || true

echo "Create folders"
mkdir -p out/WEB-INF

echo "Copy libs"
cp -vR lib out/WEB-INF/lib

echo "Copy static"
cp -Rv static/* out/

echo "Copy web.xml"
cp -v web.xml out/WEB-INF/

echo "Compile"
javac -verbose src/ru/rogin/demo/*.java -d out/WEB-INF/classes

echo "Create folder"
mkdir out/war

echo "Pack"
(
    cd out &&
    jar -cfv war/ROOT.war .
)

echo "Run docker"
docker run -it --rm --name tomcat -p 8888:8080 -v $(pwd)/out/war:/usr/local/tomcat/webapps tomcat:9.0
