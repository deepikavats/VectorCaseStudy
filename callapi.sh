result=$(curl -X GET --header "Accept: */*" "http://localhost:8081/reserveLicense?compilerName=javac")
echo "Response from server"
echo $result
if [ $result == "Successful" ]
then
  maven package
  curl -X GET --header "Accept: */*" "http://localhost:8081/freeLicense"
else
  echo "License is not available"
  exit -1
fi
exit