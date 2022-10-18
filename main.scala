// define the URL for input file access.csv
var inputFileUrl = "hdfs://localhost:9000/bd-project-input/access.csv";
// define the URL for output directory output
var outputUrl = "hdfs://localhost:9000/bd-project-output/output";

// read csv file from HDFS
var completeLogs = spark.read.csv(inputFileUrl);
// select first column(IP addresses), and convert it to string
var ipLogs = completeLogs.select("_c0").map(x => x.toString).map(x => x.stripPrefix("[").stripSuffix("]"));
// collect
var ipLogs2 = ipLogs.collect;
// create RDD
var ipLogsRdd = sc.parallelize(ipLogs2);
// map and reduce
var ipCount = ipLogsRdd.map(x => (x, 1)).reduceByKey(_ + _);
// convert to DataFrame
var tempDF = ipCount.toDF;
// repartition to create only 1 file
var resultDF = tempDF.repartition(1);
// convert to CSV
var resultCSV = resultDF.write.format("csv");
// save to HDFS
resultCSV.save(outputUrl);
