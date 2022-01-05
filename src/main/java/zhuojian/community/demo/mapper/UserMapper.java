package zhuojian.community.demo.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import zhuojian.community.demo.model.User;

/**
 * Created by iZfx on 2022/1/3 22:21
 */
@Repository
@Mapper
public interface UserMapper {
    @Insert("insert into user (account_id,name,token,gmt_create,gmt_modified) values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}