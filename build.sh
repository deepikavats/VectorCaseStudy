mvn package

result=$(curl -X GET --header "Accept: */*" "https://8081-cs-73f3bf7e-48b8-4f95-a6b5-7f6de9ac6684.cs-europe-west1-onse.cloudshell.dev/getLicense?compilerName=gcc")
echo "Response from server"
echo $result