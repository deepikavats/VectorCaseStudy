result=$(curl -X GET --header "Accept: */*" "http://localhost:8081/getLicense?compilerName=gcc")
echo "Response from server"
echo $result
if [ $result == "Successful" ]
then
  maven package
  curl -X GET --header "Accept: */*" "http://localhost:8081/freeLicense"
else
  echo "License is not available"
fi
exit