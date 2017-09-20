# ReactiveVSBlockingCRUD
The main purpose of the project was to investigate performance of CRUD operations based on blocking and non-blocking operations. I chose MongoDB database for . For this purpose there were chosen MongoRepository and ReactiveMongoRepository. Application was running on server and load testing performed on local machine with Apache Jmeter. Based on results, i can say that operations with non-reactive style were performed faster than in reactive semantic when we have a small amount of users(threads) - up to 20, but when we use more threads, program failed with GC overhead error, even if program started with 1024M memory size. Files with test result atached to repository.