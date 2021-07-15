#PUT request returns a token required for subsequent GET requests and is only valid for the existing EC2 instance

TOKEN=`curl --request PUT "http://169.254.169.254/latest/api/token" --header "X-aws-ec2-metadata-token-ttl-seconds: 21600"` 

#The value of Token has been echoed in the TOKEN variable.

echo ${TOKEN}


#Pass the token generated from above command to the GET request. Adding /latest/meta-data/ to the end of the URI will view all categories 
# The --write-out option is used to allow a space after the returned value
# A list is returned with over 20 options available to query

curl --write-out "\n" --request GET "http://169.254.169.254/latest/meta-data" --header "X-aws-ec2-metadata-token: $TOKEN"

#Dynamic data contains information about the instance identity documents
#The types of information included in dynamic data are account ID, region, and certificates
#The output generated will be in JSON format

curl --write-out "\n" --request GET "http://169.254.169.254/latest/dynamic/instance-identity/document" --header "X-aws-ec2-metadata-token: $TOKEN"


#Below command can be used to generate the public keys

curl --write-out "\n" --request GET "http://169.254.169.254/latest/meta-data/public-keys" --header "X-aws-ec2-metadata-token: $TOKEN"

