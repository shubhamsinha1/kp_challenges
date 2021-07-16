variable "ami" {
  type = string
  default = "ami-04bde106886a53080"
}

variable "aws_access_key" {}

variable "aws_secret_key" {}

variable "region" {
   default = "ap-south-1"
}


variable "instance_type" {
  type = map
  default = {
      default = "t2.micro",
      cert    = "t2.micro",
      prod    = "t3a.nano",
      dev     = "t2.nano"
  }
}

variable "ec2_name" {
  type = map
  default = {
      default = "",
      prod    = "prod_ec2_workspace",
      cert    = "cert_ec2_instnace"
      dev     = "dev_ec2_workspace"

  }
}

