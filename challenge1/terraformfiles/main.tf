terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }
}

provider "aws" {
  region     = "${var.region}"
  access_key = "${var.aws_access_key}"
  secret_key = "${var.aws_secret_key}"
}

resource "aws_instance" "My_ec2_instance" {
  ami = var.ami
  instance_type = lookup(var.instance_type, terraform.workspace)
  tags = {
      Name = lookup(var.ec2_name, terraform.workspace)
  }
}

