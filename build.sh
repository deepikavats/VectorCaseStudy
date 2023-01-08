mvn package

result=$(curl -X GET --header "Accept: */*" "http://35.232.115.31:8081/getLicense?compilerName=gcc")
echo "Response from server"
echo $result