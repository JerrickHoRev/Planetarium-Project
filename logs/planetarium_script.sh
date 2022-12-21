grep Response rollingFile.log | cut -f 1 -d, | tr -d "[]"
httpCodes=$(grep Response rollingFile.log | cut -f 1 -d, | tr -d "[]" | cut -f 2 -d " ")
# then create any necessary variables to measure your SLI
httpRequestTotal=0
httpFailures=0


# then loop through the log data and perform any necessary operations to initialize your variables
for code in $httpCodes
do
        ((httpRequestTotal++))
        if [ $code -eq 500 ]
        then
                ((httpFailures++))
        fi
done

# save the SLI value and return it

httpSuccess=$(($httpRequestTotal - $httpFailures))

result=$(awk "BEGIN {print $httpSuccess / $httpRequestTotal * 100}") # this is an alternative way to get the same result as above if bc does not work

echo "HTTP success rate: $result%"