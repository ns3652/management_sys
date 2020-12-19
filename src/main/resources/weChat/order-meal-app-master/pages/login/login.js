// pages/login/login.js
const app = getApp()
var baseUrl = app.globalData.host;
Page({

    /**
     * 页面的初始数据
     */
    data: {
        username:'',
        password:'',
        type:'password',
        userInfo: {},
        hasUserInfo: true,
        canIUse: wx.canIUse('button.open-type.getUserInfo'),

        jscode:'',
        weChatLoginRequest:{
            jscode:'',
            nickName:'',
            avatarUrl:null,
            gender:null,
            language:'',
            country:'',
            province:'',
            city:''
        }
    },

    getUserInfo: function(e) {
        let data = JSON.parse(e.detail.rawData)
        console.log('data:' + data)
        app.globalData.userInfo = e.detail.userInfo
        let that = this
        this.setData({
          userInfo: e.detail.userInfo,
          hasUserInfo: !that.data.hasUserInfo
        })
        let request = that.data.weChatLoginRequest
        console.log(data.nickName)
        request.nickName=data.nickName
        request.avatarUrl=data.avatarUrl
        request.gender=data.gender
        request.language=data.language
        request.country=data.country
        request.province=data.province
        request.city=data.city
        wx.login({
          complete: (res) => {
              request.jscode=res.code
              console.log(request)
              wx.request({
                url: baseUrl+'/auth/weChatLogin', 
                data: {
                    jscode:request.jscode,
                    nickName:request.nickName,
                    avatarUrl:request.avatarUrl,
                    gender:request.gender,
                    language:request.language,
                    country:request.country,
                    province:request.province,
                    city:request.city
                },
                method: 'post',
                header: {
                    "Content-Type":"application/x-www-form-urlencoded" // 默认值
                },
                success: function(res) {
                    var status = res.data.success
                    console.log(res)
                    //登陆成功
                    if (status){
                        wx.setStorageSync('token',res.data.data.token)
                        wx.setStorageSync('weChatInfo', request)
                        wx.switchTab({ url: '../index/index' })//跳转到首页
                    }else{
                        wx.showToast({
                            title: '授权失败',
                            icon:'none',
                            duration:4000
                        })
                    }
                }
              })
          },
        })
    },

    usernameInput(e){
        this.setData({
            username:e.detail.value
        })
    },

    passwordInput(e){
        this.setData({
            password:e.detail.value
        })
    },

    thirdPartyLogin(){
        this.setData({
            hasUserInfo: false 
        })
    },

    _handlerClick (evt) {
        //console.log('weChatLoginRequest'+JSON.stringify(wx.getStorageSync('weChatLoginRequest')))
        let that = this
        //wx.switchTab({ url: '../index/index' })//跳转到首页
        if ((that.data.username == null || that.data.username =='') || (that.data.password == null ||that.data.password == '')){
            wx.showToast({
                title: '账号密码不能为空',
                icon:'none',
                duration:4000
              })
        }else{
            wx.request({
                url: baseUrl+'/auth/login', 
                data: {
                   username: that.data.username,
                   password: that.data.password
                },
                method: 'post',
                header: {
                    'content-type': 'application/x-www-form-urlencoded' // 默认值
                },
                success: function(res) {
                    var status = res.data.success
                    console.log(res)
                    //登陆成功
                    if (status){
                        that.data.weChatLoginRequest.nickName = that.data.username
                        wx.setStorageSync('weChatInfo', that.data.weChatLoginRequest)
                        wx.setStorageSync('token',res.data.data)
                        wx.switchTab({ url: '../index/index' })//跳转到首页
                        
                    }else{
                        wx.showToast({
                          title: '账号密码错误',
                          icon:'none',
                          duration:4000
                        })
                    }
                }
            })
        }
        
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {

    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {

    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})