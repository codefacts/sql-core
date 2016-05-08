package io.crm.sql;

/**
 * Created by shahadat on 5/7/16.
 */
public class MMM {
    public static void mm() {
        String ss = "SELECT AREAS.REGION_ID, DISTRIBUTION_HOUSES.AREA_ID, DISTRIBUTION_HOUSES.DISTRIBUTION_HOUSE_NAME, DISTRIBUTION_HOUSES.LOCATION, Sum(Daily_BR_Achievement.Achievement) AS SumOfAchievement, Count(SMS_INBOX.SMS_ID) AS DataReceived, Count(IIf([SMS_INBOX].[MC_LAST_CALL_STATUS_ID] In (1,2,4),True,Null)) AS MCChecked, Count(IIf([SMS_INBOX].[MC_LAST_CALL_STATUS_ID] In (0,3),True,Null)) AS MCNotChecked, Count(IIf([SMS_INBOX].[MC_LAST_CALL_STATUS_ID]=1,True,Null)) AS [Mobile On], Count(IIf([SMS_INBOX].[MC_LAST_CALL_STATUS_ID]=2 And [SMS_INBOX].[MC_VERIFY_COUNT]>0,True,Null)) AS [Mobile Off], Count(IIf([SMS_INBOX].[MC_LAST_CALL_STATUS_ID]=4 And [SMS_INBOX].[MC_VERIFY_COUNT]>0,True,Null)) AS WrongNumber, Count(IIf([SMS_INBOX].[PTR]=True,True,Null)) AS [PTR Achieved], Count(IIf([SMS_INBOX].[MC_LAST_CALL_STATUS_ID]=2 And [SMS_INBOX].[MC_VERIFY_COUNT]>0 And [SMS_INBOX].[PTR]=True,True,Null)) AS [PTR Mobile Off], Count(QRY_DUPLICATE_CONTACTS.SMS_ID) AS DuplicateData, Count(IIf([QRY_DUPLICATE_CONTACTS].[DUPLICATE_STATUS_ID]=1,True,Null)) AS Genuine, Count(IIf([QRY_DUPLICATE_CONTACTS].[DUPLICATE_STATUS_ID]=3,True,Null)) AS Repeat, Count(IIf([QRY_DUPLICATE_CONTACTS].[DUPLICATE_STATUS_ID]=2,True,Null)) AS Fake, Count(IIf([QRY_DUPLICATE_CONTACTS].[DUPLICATE_STATUS_ID] In (1,2,3),True,Null)) AS Verified, Count(IIf([QRY_DUPLICATE_CONTACTS].[DUPLICATE_STATUS_ID]=0,True,Null)) AS NotVerified, Count(CALLS.CALL_ID) AS TotalCalls, Count(IIf([CALL_STATUS_ID]=1,True,Null)) AS Success, Count(IIf([CALL_STATUS_ID]<>1,True,Null)) AS Unsuccess" +
            "FROM (AREAS RIGHT JOIN (DISTRIBUTION_HOUSES RIGHT JOIN ((((BRS RIGHT JOIN SMS_INBOX ON BRS.BR_ID = SMS_INBOX.BR_ID) LEFT JOIN QRY_DUPLICATE_CONTACTS ON SMS_INBOX.SMS_ID = QRY_DUPLICATE_CONTACTS.SMS_ID) LEFT JOIN CALLS ON SMS_INBOX.SMS_ID = CALLS.CALL_ID) LEFT JOIN DUPLICATE_UPLOADED_IDs ON SMS_INBOX.SMS_ID = DUPLICATE_UPLOADED_IDs.SMS_ID) ON DISTRIBUTION_HOUSES.DISTRIBUTION_HOUSE_ID = BRS.DISTRIBUTION_HOUSE_ID) ON AREAS.AREA_ID = DISTRIBUTION_HOUSES.AREA_ID) LEFT JOIN Daily_BR_Achievement ON BRS.BR_ID = Daily_BR_Achievement.BR_ID" +
            "WHERE (((DUPLICATE_UPLOADED_IDs.SMS_ID) Is Null) AND ((SMS_INBOX.Date) Between #5/1/2016# And #5/31/2016#))" +
            "GROUP BY AREAS.REGION_ID, DISTRIBUTION_HOUSES.AREA_ID, DISTRIBUTION_HOUSES.DISTRIBUTION_HOUSE_NAME, DISTRIBUTION_HOUSES.LOCATION" +
            "HAVING (((AREAS.REGION_ID) Is Not Null))" +
            "ORDER BY DISTRIBUTION_HOUSES.DISTRIBUTION_HOUSE_NAME;";
    }
}
