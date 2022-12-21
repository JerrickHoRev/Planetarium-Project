grep Response rollingFile.log
httpCodes=$(grep Response rollingFile.log | cut -f 1 -d, | tr -d "[]" | cut -f 2 -d " ")
httpRequestTotal=0
httpFailures=0


for code in $httpCodes
do
        ((httpRequestTotal++))
        if [ $code -eq 500 ]
        then
                ((httpFailures++))
        fi
done


httpSuccess=$(($httpRequestTotal - $httpFailures))

result=$(awk "BEGIN {print $httpSuccess / $httpRequestTotal * 100}" end) 
echo "HTTP success rate: $result%"

httpResponse=$(grep Response rollingFile.log | cut -f 2 -d, | cut -f 4 -d " ")
httpResponseTotal=0
httpResponseTime=0


for code in $httpResponse
do
        ((httpResponseTotal++))
done

sum=$(awk '{ sum += $0 } END { print sum }' values.txt)

ResponseAverage=$(awk "BEGIN {print $sum / $httpResponseTotal}")

echo "HTTP Response Average: $ResponseAverage"