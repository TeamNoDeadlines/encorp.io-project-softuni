//package com.NoDeadlines.SoftUniFestApp2023.helpers;


//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//
//@Deprecated
//public class SqlHelpers {
//
//    public static List<User> getUsersFromRS(ResultSet resultSet) throws SQLException {
//        List<User> dbUsers = new ArrayList<>();
//
//        while(resultSet.next()){
//            dbUsers.add(getUserRs(resultSet));
//        }
//        return  dbUsers;
//    }
//
//    public static User getUserFromRS(ResultSet resultSet) throws SQLException{
//        if(resultSet.next())
//            return getUserRs(resultSet);
//        throw new SQLException();
//    }
//
//    public static  List<Comment> getCommentsFromRS(ResultSet resultSet) throws SQLException{
//
//        List<Comment> dbComments = new ArrayList<>();
//
//        while(resultSet.next()){
//            dbComments.add(getCommentRs(resultSet));
//        }
//
//        return dbComments;
//    }
//
//    public static Comment getComment(ResultSet resultSet) throws SQLException {
//        Comment comment = null;
//        while (resultSet.next())
//            comment = getCommentRs(resultSet);
//        if(comment != null)
//            return comment;
//        else
//            throw new SQLException();
//    }
//
//    private static Comment getCommentRs(ResultSet resultSet) throws SQLException {
////        Comment comment = new Comment(
////                resultSet.getInt("id"),
////                resultSet.getInt("fk_post_id"),
////                resultSet.getInt("fk_user_id"),
////                resultSet.getString("content")
////        );
//
//        return null;
//    }
//
//    private static User getUserRs(ResultSet resultSet) throws SQLException{
//        User user = new User(resultSet.getInt("userId"),
//                resultSet.getString("firstName"),
//                resultSet.getString("lastName"),
//                resultSet.getString("username"),
//                resultSet.getString("password"),
//                resultSet.getBoolean("isAdmin")
//        );
//        return user;
//    }
//
//
//}
