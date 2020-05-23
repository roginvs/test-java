set -e

echo "Clean"
if [ -d out ]; then
  rm -Rf out
fi

if [ ! -f lib/servlet-api.jar ]; then
  echo "Unpack lib"
  docker run --rm tomcat:9.0 bash -c 'cat /usr/local/tomcat/lib/servlet-api.jar' > lib/servlet-api.jar
fi

echo "Create folders"
mkdir -p out/WEB-INF

echo "Copy libs"
cp -vR lib out/WEB-INF/lib

echo "Copy static"
cp -Rv static/* out/

echo "Copy web.xml"
cp -v web.xml out/WEB-INF/

echo "Compile"
javac -verbose -classpath .:./lib/servlet-api.jar \
  src/ru/rogin/demo/*.java \
  -d out/WEB-INF/classes

echo "Create folder"
mkdir out/war

echo "Pack"
(
    cd out &&
    jar -cfv war/ROOT.war .
)

echo "Run docker"
docker run -it --rm --name tomcat -p 8888:8080 \
 -v $(pwd)/out/war/ROOT.war:/usr/local/tomcat/webapps/ROOT.war tomcat:9.0
