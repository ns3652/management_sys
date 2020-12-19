// pages/register/register.js
const app = getApp()
var baseUrl = app.globalData.host;
Page({

    /**
     * 页面的初始数据
     */
    data: {
        type1:'password',
        type2:'password',
        items: [
            { name: 'men', value: '男' },
            { name: 'women', value: '女' }

            // { name: 'men', value: '男', disabled: true },
            // { name: 'women', value: '女', checked: true },
            // { name: 'BRA', value: '巴西' }
        ],
        seleted: "",
        username:'',
        password:'',
        password2:'',
        weChatLoginRequest:{}
    },
    radioChange: function (evt) {
        console.log('radio发生change事件，携带value值为：', evt.detail.value)
        let value = evt.detail.value;
        this.setData({
            seleted: "选中的value：" + value
        })
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        // 设置导航栏为对应导航
        wx.setNavigationBarTitle({
            title: '用户注册'
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

    passwordInput2(e){
        this.setData({
            password2:e.detail.value
        })
    },

    _handlerClick (evt) {
        let that = this
        let username = that.data.username
        let password = that.data.password
        let password2 = that.data.password2
        if (username == null || username == ''){
            wx.showToast({
                title: '账号名不能为空',
                icon:'none'
            }) 
        }else if (password == null || password == ''){
            wx.showToast({
                title: '密码不能为空',
                icon:'none'
            }) 
        }else if (password != password2){
            wx.showToast({
               title: '密码不一致',
               icon:'none'
            })   
        }else{
            wx.request({
                url: baseUrl+'/register/addUser', 
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
                    //注册成功
                    if (status){
                     
                        //wx.setStorageSync('token',res.data.)
                        
                        //直接登录
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
                                //登录成功
                                if (status){
                                    that.data.weChatLoginRequest.nickName = that.data.username
                                    wx.setStorageSync('weChatInfo', that.data.weChatLoginRequest)
                                    wx.setStorageSync('token',res.data.data)
                                    wx.switchTab({ url: '../index/index' })//跳转到首页 
                                }else{
                                    wx.showToast({
                                      title: '登录异常',
                                      icon:'none',
                                      duration:4000
                                    })
                                }
                            }
                        })

                        wx.switchTab({
                          url: '../index/index',
                        })
                    }else{
                        wx.showToast({
                          title: res.data.message,
                          icon:'none'
                        })
                    }
                }
            })
        }

        
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