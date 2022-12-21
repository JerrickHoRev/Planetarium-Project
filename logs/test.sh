httpResponse=$(grep Response rollingFile.log | cut -f 2 -d, | cut -f 4 -d " ")


echo $httpResponse | tr -s ' \t' '\n' >> values2.txt