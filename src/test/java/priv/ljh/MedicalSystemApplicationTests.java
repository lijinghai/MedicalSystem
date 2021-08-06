package priv.ljh;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.ucom.interfacecore.BusiInterface;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

@SpringBootTest
class MedicalSystemApplicationTests {


    /**
     * uni-app端代码
     */
    @Test
    void uniapp() {

        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();

        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("lijinghai");
        //是否打开windows文件夹
        gc.setOpen(false);
        //是否覆盖原来生成的代码
        gc.setFileOverride(false);

        // 去Service的I前缀
        gc.setServiceName("%sService");


        gc.setIdType(IdType.ID_WORKER);
        //配置日期类型
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://42.192.231.74:3308/icms?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("@Wxyabyt888");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3、包的配置
        PackageConfig pc = new PackageConfig();
        //只需要改实体类名字 和包名 还有 数据库配置即可
        pc.setModuleName("uniapp");
        pc.setParent("priv.ljh");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表名
        strategy.setInclude("user","patient_data","bladder_data","urine_data","renal_data","ureteral_data","events");

        // 设置要映射的表名
        //包的名字下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //列的名字下划线转驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok
        strategy.setEntityLombokModel(true);

        // 逻辑删除
        strategy.setLogicDeleteFieldName("deleted");

        // 自动填充配置
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        // 乐观锁
        strategy.setVersionFieldName("version");
        // 开启RestFull的风格
        strategy.setRestControllerStyle(true);
        // localhost:8080/hello_id_2
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);
        mpg.execute(); //执行
    }

    @Test
    public void test() throws SQLException {
        Connection conn= null;

        String driver= "com.mysql.cj.jdbc.Driver";

        String url= "jdbc:mysql://42.192.231.74:3308/icms?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";

        String username= "root";

        String password= "@Wxyabyt888";

        try {
            Class.forName(driver);

            conn= DriverManager.getConnection(url, username, password);

            System.out.println("TestConnectionByJDBC success");

            BusiInterface bi = new BusiInterface(conn);
            System.out.println(bi.getNextTime());

            conn.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
