# named-entity-graph-demo


References that I used for understanding:

- https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.entity-graph
- https://www.thoughts-on-java.org/jpa-21-entity-graph-part-1-named-entity/
- https://blog.ippon.tech/boost-the-performance-of-your-spring-data-jpa-application/

Successfully loaded 3 level relationship using single sql query : Task -> Aspects -> Anchors

Avoided MultipleBagFetchException exception by using Set instead of lists.

```sql

 select
        taskentity0_.task_id as task_id1_2_0_,
        aspects1_.aspect_id as aspect_i1_1_1_,
        anchors2_.anchor_id as anchor_i1_0_2_,
        taskentity0_.task_name as task_nam2_2_0_,
        aspects1_.aspect_name as aspect_n2_1_1_,
        aspects1_.task_id as task_id3_1_1_,
        aspects1_.task_id as task_id3_1_0__,
        aspects1_.aspect_id as aspect_i1_1_0__,
        anchors2_.anchor_name as anchor_n2_0_2_,
        anchors2_.aspect_id as aspect_i3_0_2_,
        anchors2_.aspect_id as aspect_i3_0_1__,
        anchors2_.anchor_id as anchor_i1_0_1__ 
    from
        task taskentity0_ 
    left outer join
        aspects aspects1_ 
            on taskentity0_.task_id=aspects1_.task_id 
    left outer join
        anchors anchors2_ 
            on aspects1_.aspect_id=anchors2_.aspect_id

```