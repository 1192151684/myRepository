package com.sam.wms.serivce;

import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.SellingPartnerAPIAA.AWSAuthenticationCredentialsProvider;
import com.amazon.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import static com.amazon.SellingPartnerAPIAA.ScopeConstants.SCOPE_NOTIFICATIONS_API;
import static com.amazon.SellingPartnerAPIAA.ScopeConstants.SCOPE_MIGRATION_API;

import io.swagger.client.ApiException;
import io.swagger.client.api.SellersApi;
import io.swagger.client.model.GetMarketplaceParticipationsResponse;
import io.swagger.client.model.MarketplaceParticipation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sam
 * date:2021.03.2021/3/8
 * time:10:34
 */
@Service
public class SystemService {

    public static void main(String[] args) {

        //步骤1.配置您的AWS凭证
        AWSAuthenticationCredentials awsAuthenticationCredentials = AWSAuthenticationCredentials.builder()
                .accessKeyId("AKIAJBS6PCAA3LBB3ETA")                              // accessKeyId( Your AWS access key Id)
                .secretKey("3asUB9XII+g900AbU3UlepURzus1CDuI11XdV638")            // secretKey
                .region("us-east-1")                                         //地区 marketplaceId A1805IZSGTT6HS
                .build();

        // 步骤2.配置您的AWS凭证提供商 IAM角色
        AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider = AWSAuthenticationCredentialsProvider.builder()
                .roleArn("arn:aws:iam::579974362352:user/qilin")                                       //IAM
                .roleSessionName("qilin")           //您定义的会话的标识符。我们建议使用通用唯一标识符（UUID）。
                .build();

        //步骤3.，配置您的LWA凭据 需要授权
        LWAAuthorizationCredentials lwaAuthorizationCredentials = LWAAuthorizationCredentials.builder()
                .clientId("amzn1.application-oa2-client.e3138d4ebb6c4082a97d27704d920002")                       //clientid
                .clientSecret("6610d9aa02c159c5f4452da498b73a84a898fe8fe95982026ffa83d21318eb33")                //client_secret
                .endpoint("https://api.amazon.com/auth/o2/token")
                .build();

      /*  //步骤4.，配置您的LWA凭据 无授权
        LWAAuthorizationCredentials lwaAuthorizationCredentials =
                LWAAuthorizationCredentials.builder()
                        .clientId("amzn1.application-oa2-client.199d7dcdb84e4c3b82410968037e1083")                             //clientId
                        .clientSecret("f59f5a5c3613c4ca116a7388cae7d21d5aa583bc5b58f49a0ed2a56cbcbe4913")                    // 您的LWA客户密钥
                        .withScopes(SCOPE_NOTIFICATIONS_API, SCOPE_MIGRATION_API)
                        .endpoint("https://api.amazon.com/auth/o2/token")
                        .build();
*/
        //步骤4.创建Sellers API实例并调用操作
        SellersApi sellersApi = new SellersApi.Builder()
                .awsAuthenticationCredentials(awsAuthenticationCredentials)
                .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
                .awsAuthenticationCredentialsProvider(awsAuthenticationCredentialsProvider)
                .endpoint("https://sellingpartnerapi-na.amazon.com")
                .build();

        //sellapi
        try {
            System.out.println("DDDDDDD");
            GetMarketplaceParticipationsResponse result = sellersApi.getMarketplaceParticipations();

            System.out.println(result.toString()+"DDDDDDD");


            GetMarketplaceParticipationsResponse res = sellersApi.getMarketplaceParticipations();
            List<MarketplaceParticipation> data = new ArrayList<MarketplaceParticipation>();
            data = res.getPayload();
            for (MarketplaceParticipation obj : data) {
                System.out.println(obj);
            }

        } catch (ApiException e) {
            System.err.println("Exception when calling SellersApi#getMarketplaceParticipations");
            e.printStackTrace();
        }



    }
    }
