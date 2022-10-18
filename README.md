# Problem Statement

Find the number of times each IP accessed the website

# Instructions

- Start all Hadoop daemons using `start-yarn.sh` and `start-dfs.sh`
- Create a directory in HDFS to store the input file `access.csv` using `hdfs dfs -mkdir /bd-project-input`
- Copy over the `access.csv` file from local filesystem to HDFS using `hdfs dfs -put [/path/to/file] /bd-project-input`
- Check if the directory has been succesfully created using `hdfs dfs -ls /`
- Create a directory in HDFS to store the output file using `hdfs dfs mkdir /bd-project-output`
- Check if the file has been succesfully copied over using `hdfs dfs -ls /bd-project-input`
- Evaluate the program in spark using `spark-shell < main.scala`
- Check if the output file is present in HDFS using `hdfs dfs -ls /bd-project-output/output`
- Print out the contents of the output using `hdfs dfs -cat /bd-project-output/output/*`
