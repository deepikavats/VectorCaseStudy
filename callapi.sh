result=$(curl -X GET --header "Accept: */*" "http://35.232.115.31:8081/reserveLicense?compilerName=javac")
echo "Response from server"
echo $result
if [ $result == "Successful" ]
then
  mvn package
  curl -X GET --header "Accept: */*" "http://35.232.115.31:8081/freeLicense"
else
  echo "License is not available"
  exit 1
fi
exit