chmod 400 $aws_pem
ssh -o "StrictHostKeyChecking=no" -i $aws_pem $aws_user@$aws2_ip "rm -rf ws-bank"
ssh -o "StrictHostKeyChecking=no" -i $aws_pem $aws_user@$aws2_ip "mkdir ws-bank"
scp -o "StrictHostKeyChecking=no" -r -i $aws_pem * $aws_user@$aws2_ip:~/ws-bank